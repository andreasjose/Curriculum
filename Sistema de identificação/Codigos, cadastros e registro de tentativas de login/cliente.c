 #include <stdio.h>	
 #include <unistd.h>
 #include <stdlib.h>
 #include <errno.h>	
 #include <string.h>	
 #include <sys/types.h>	
 #include <sys/socket.h>	
 #include <netinet/in.h>	
 #include <arpa/inet.h>	
 #include <netdb.h>	
 #include <time.h>
 
struct usuario
{
	int codigo;
	char nome[50];
	time_t it;
	int acesso;
	char autorizacao;
};
	
 /*	
 * Esta função reporta erro e finaliza do programa
 */	
 static void	
	bail(const char *on_what) {	
	if ( errno != 0 ) {	
		fputs(strerror(errno),stderr);	
		fputs("	 ",stderr);
	}	
	fputs(on_what,stderr);	
	fputc('\n',stderr);	
	exit(1);	
 }
	
	
 int main(int argc,char *argv[]) {	
	 int z;
	 char *srvr_addr = NULL;
	 srvr_addr = "127.0.0.1";
	 char *srvr_port = "9099";
	 struct sockaddr_in adr_srvr;/* AF_INET */
	 int len_inet; /* comprimento */
	 int s; /* Socket */
	 char dtbuf[128]; /* InformaÃ§Ã£o de data e hora */
	 int n;
	 struct usuario login;

	for(;;){

	 //Prencher a solicitação de login
	 printf("Digite o Código de acesso: ");
	 scanf("%d", &login.codigo);
	 if ( argc >= 2 ) {

	/* Verifica se a porta foi passada via linha de comando	 */
		login.acesso = atoi(argv[1]);
	 }
		/*
		* Gera a data e hora atual:
		*/
		time(&login.it);
		n = (int) strftime(dtbuf,sizeof dtbuf, "%d/%b/%Y - %H:%M:%S", localtime(&login.it));
		dtbuf[n] = 0;

	 //Termina de Preencher	

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
	 adr_srvr.sin_addr.s_addr =
	 inet_addr(srvr_addr);
	 if ( adr_srvr.sin_addr.s_addr == INADDR_NONE )
		 bail("bad address.");

	 /*
	 * Conecta com o servidor
	 */
	 len_inet = sizeof adr_srvr;

	 z = connect(s,(struct sockaddr *) &adr_srvr,len_inet);
	 if ( z == -1 )
	 bail("connect(2)");
 	 //conecta servidor


	 //Escreve no Socket do Servidor
	 z = write(s,(const void *) &login,sizeof(struct usuario));
	 if ( z == -1 )
		bail("write(2)");
	 //termina de escrever no Socket do Servidor

	
	 //lê mensagem do servidor
	 z = read(s,&login,sizeof(struct usuario));
	 if ( z == -1 )
		 bail("read(2)");
	 //termina de lê a mensagem do servidor
	 

	 //imprime o nome do usuario e se foi permitido ele entrar na porta
	 if(login.autorizacao == 'N')
	 {
		printf("Nome:%s, Acesso negado\n",login.nome);
	 }
	 else
	 {
	 	printf("Nome:%s, Acesso autorizado\n",login.nome);
	 }
	 	
	 /*	
	 * Fecha o socket	
	 */	
	 close(s);	
	 putchar('\n');
	}
		
	 return 0;	
}
