#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

struct usuario
{
	int codigo;
	char nome[50];
	time_t it;
	int acesso;
	char autorizacao;
};

/*
* Esta funÃ§Ã£o reporta erro e finaliza do programa:
*/
static void
bail(const char *on_what) {
	if ( errno != 0 ) {
		fputs(strerror(errno),stderr);
		fputs(": ",stderr);
	}
	fputs(on_what,stderr);
	fputc('\n',stderr);
	exit(1);
}

/*
	Essa função conta o numero de registro no arquivo de cadastros
*/
int contaregistros()
{
	int i = 0;
	FILE *registro;
	registro = fopen("cadastros.txt", "rt");
	char linha[129];
	while(!feof(registro))
 	{
		fscanf(registro, " %129[^\n]", linha);
		i++;
	}
	fclose(registro);
	return i;
}

int main(int argc,char **argv) {
	int z;
	char *srvr_addr = NULL;
	srvr_addr = "127.0.0.1";
	char *srvr_port = "9099";
	struct sockaddr_in adr_srvr;/* AF_INET */
	struct sockaddr_in adr_clnt;/* AF_INET */
	int len_inet; /* comprimento  */
	int s; /* Socket do servidor */
	int c; /* Socket par ao cliente */
	int n; /* nÃºmero de bytes lidos */
	time_t td; /* Data e hora atual */
	char dtbuf[128]; /* InformaÃ§Ãµes de data e hora */
	struct usuario login;


	/* 
	Armazena informações de acesso
	*/
	int numreg; //numero de registros
	numreg = contaregistros();
	
	FILE *registro;
	registro = fopen("cadastros.txt", "rt");
	char linha[129];
	struct usuario usureg[numreg]; //usuarios salvos no arquivo

	const char ts[2] = ",";
  	char *token;
	token = strtok(linha, ts);

	int j=1;

	while(j != numreg)
 	{
    
	 	fscanf(registro, " %129[^\n]", linha);
    
		token = strtok(linha, ts);
    
		for(int i = 0; i < 3; i++)
		{
			if(i == 0)
			{
				usureg[j].codigo = atoi(token);
			}
			if(i == 1)
		        {
				strcpy(usureg[j].nome, token);
			}
			if(i == 2)
			{
				usureg[j].acesso = atoi(token);
			}
    
			token = strtok(NULL, ts);
		}
		j++;
	}
	fclose(registro);
	/*
	acaba aqui a parte de armazenar o codigo
	*/


/*
* Cria um socket do tipo TCP
*/
	s = socket(PF_INET,SOCK_STREAM,0);
	if ( s == -1 )
		bail("socket()");

/*
 * Preenche a estrutura do socket com a porta e endereÃ§o do servidor
 */
	memset(&adr_srvr,0,sizeof adr_srvr);
	adr_srvr.sin_family = AF_INET;
	adr_srvr.sin_port = htons(atoi(srvr_port));
	if ( strcmp(srvr_addr,"*") != 0 ) {
		/* EndereÃ§o normal */
		adr_srvr.sin_addr.s_addr = inet_addr(srvr_addr);
		if ( adr_srvr.sin_addr.s_addr == INADDR_NONE )
			bail("bad address."); 
	} else {
		/* Qualquer endereÃ§o */
		adr_srvr.sin_addr.s_addr = INADDR_ANY;
	}

/*
* Liga (bind) o socket com o endereÃ§o/porta
*/
	len_inet = sizeof adr_srvr;
	z = bind(s,(struct sockaddr *)&adr_srvr, len_inet);
	if ( z == -1 )
		bail("bind(2)");

/*
* Coloca o socket do servidor em estado de "escuta"
*/
	z = listen(s,10);
	if ( z == -1 )
		bail("listen(2)");

/*
* Inicia o loop do servido:
*/
	for (;;) {
		/*
		* Aguarda por uma solitaÃ§Ã£o de conexÃ£o:
		*/
			len_inet = sizeof adr_clnt;
			c = accept(s,(struct sockaddr *)&adr_clnt,&len_inet);

			if ( c == -1 )
				bail("accept(2)");

		//lê mensagem do cliente
		z = read(c,&login,sizeof(struct usuario));
			if ( z == -1 )
		 		bail("read(2)");
		
		login.autorizacao = 'N';
		char texto1[15] = "Negado";
		//verifica se as informações de acesso estão corretas
		strcpy(login.nome, " Não Encontrado");
		for(int i=0; i < numreg; i++)
		{
			if(login.codigo == usureg[i].codigo)
			{
				strcpy(login.nome, usureg[i].nome);
				if(login.acesso <= usureg[i].acesso)
				{
					login.autorizacao = 's';
					strcpy(texto1, "Autorizado");
				}
			}

		}
		
		/* Escreve o resultado no socket do cliente
		*/
		z = write(c,(const void *) &login,sizeof(struct usuario));
		if ( z == -1 )
			bail("write(2)");

		//Pega a hora do cliente
		n = (int) strftime(dtbuf,sizeof dtbuf, "%d/%b/%Y - %H:%M:%S", localtime(&login.it));
		dtbuf[n] = 0;

		// escreve no arquivo
		FILE* parq = fopen("dados.txt", "a+");

        	fprintf(parq, "%s, p%d, %d, %s \n", dtbuf, login.acesso, login.codigo, texto1);
 		
		fclose(parq);
		
		/*
		* Fecha a conexÃ£o com o cliente
		*/
		close(c);
	}
	return 0;
}
