#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum; /*this data is shared by the threads */
int maxInput = 100;
//int thread_index = 0;  //holds the index value of the thread we are currently on, + 1


void *runner(void *param);

int main(int argc, char *argv[])
{
	pthread_t tid;
	pthread_t threads[10];
	
	/*create the thread*/
	for(int i = 0; i < 10; i++){
		int* a = malloc(sizeof(int));
		*a = i;
		pthread_create(&threads[i], NULL, runner, a);
		printf("%s", "created a thread\n");
	}
	/* wait for thread to exit */
	for(int g = 0; g<10; g++){
		
		pthread_join(threads[g], NULL);
		//thread_index++;
		//printf("%d", thread_index);
		//printf("%s", "\n");
	}
	printf("sum = %d\n", sum);
	
	exit(0);
}

void *runner(void *param)
{
	int index = *(int*)param;
	printf("%s", "index is");
	printf("%d", index);
	printf("%s", "\n");
	free(param);
	
	int curValue = 0;
		int threadSum = 0;

				curValue = maxInput/10 * index + 1;
				printf("%s", "start value for this thread is ");
				printf("%d", curValue);
				printf("%s", "\n");
		
		for(int c = 0; c<maxInput/10; c++){
			printf("%d", curValue + c);
			threadSum += curValue + c;
		}
		
		sum += threadSum;
		//free(param);
		pthread_exit(0);
}