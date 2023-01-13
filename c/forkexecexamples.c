
#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int main( ) {
   char str[100];
   char selectStr[100];
   char working[] = "pwd";
   char directory[] = "ls";
   char makefile[] = "mkdir";
   char processes[] = "ps";
   char view[] = "vw";
   char leave[] = "quit";
   char commands[] = "help";
   int choice = 0;
   
   int run = 1;
   float value;
   pid_t pid;
   while ( run != 0 )   {
	   
        printf("type a command or type 'help' to see a list of commands \n")
       
        scanf("%s", selectStr);
		

		if (strcmp(selectStr, working) == 0){
			printf("Menu option 1 entered!\n");
			pid = fork();
				if (pid < 0) { /* error occurred */
					fprintf(stderr, "Fork Failed");
					return 1;
				}
				else if (pid == 0) { /* child process */
					execlp("/bin/pwd","pwd",NULL);
				}
				else { /* parent process */
					wait(NULL);
					printf("_____________________________________\n");
				}
		}
		else if(strcmp(selectStr, directory) == 0){
			printf("Menu option 2 entered!\n");

			pid = fork();
				if (pid < 0) { /* error occurred */
					fprintf(stderr, "Fork Failed");
					return 1;
				}
				else if (pid == 0) { /* child process */
					execlp("/bin/ls","ls",NULL);	
				}
				else { /* parent process */
					/* parent will wait for the child to complete */
					wait(NULL);
					printf("_____________________________________\n");
				}

		}
		else if(strcmp(selectStr, makefile) == 0){
			pid = fork();
				if (pid < 0) { /* error occurred */
					fprintf(stderr, "Fork Failed");
					return 1;
				}
				else if (pid == 0) { /* child process */
					printf("what do you want to name the file?\n");
					scanf("%s", str);
					
					execlp("/bin/mkdir","mkdir", str, (char *) 0);	
					printf("directory created with specified name");
				}
				else { /* parent process */
					/* parent will wait for the child to complete */
					wait(NULL);
					printf("_____________________________________\n");
				}
			
		}
		else if(strcmp(selectStr, processes) == 0){
			pid = fork();
				if (pid < 0) { /* error occurred */
					fprintf(stderr, "Fork Failed");
					return 1;
				}
				else if (pid == 0) { /* child process */
					
					execlp("ps","ps", NULL);	

				}
				else { /* parent process */
					/* parent will wait for the child to complete */
					wait(NULL);
					printf("_____________________________________\n");
				}
			
		}	
		else if(strcmp(selectStr, view) == 0){
			pid = fork();
				if (pid < 0) { /* error occurred */
					fprintf(stderr, "Fork Failed");
					return 1;
				}
				else if (pid == 0) { /* child process */
					printf("what file do you want to view? \n");
					scanf("%s", str);
					execlp("/bin/cat","cat", str, (char *) 0);	

				}
				else { /* parent process */
					/* parent will wait for the child to complete */
					wait(NULL);
					printf("_____________________________________\n");
				}
			
		}			
			
		
		else if(strcmp(selectStr, leave) == 0){
			
			run = 0;
			return 0;
		}
		else if(strcmp(selectStr, commands) == 0){
			
		printf("'pwd' to print working directory\n");
		printf("'ls' to list files in the active directory\n");
		printf("'mkdir' to create a new directory\n"); 
		printf("'history' to display command history\n");
		printf("'ps' to list active processes\n");
		printf("'vw' to view a file's contents\n");
		printf("'help' to see all available commands\n");
		printf("'quit' to quit\n"); 
			
		}
		else {
			printf("unknown input \n");
		}
   } // end while loop

   return 0;
}