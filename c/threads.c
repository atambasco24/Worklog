#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum; /*this data is shared by the threads */
int maxInput= 100;


void *runner(void *param);

int main(int argc, char *argv[])
{
	
	maxInput = atoi(argv[1]); // ./a.out x , where x is a number divisible by 10
	pthread_t tid;
	pthread_t threads[10];
	
	/*create the thread*/
	for(int i = 0; i < 10; i++){
		int* a = malloc(sizeof(int));
		*a = i;
		pthread_create(&threads[i], NULL, runner, a);

	}
	/* wait for thread to exit */
	for(int g = 0; g<10; g++){
		
		pthread_join(threads[g], NULL);
	}
	printf("sum = %d\n", sum);
	
	exit(0);
}

void *runner(void *param)
{
	int index = *(int*)param;
	free(param);
	
	int curValue = 0;
	int threadSum = 0;

		curValue = maxInput/10 * index + 1; //operation to evenly split the max value between each of the 10 threads
		for(int c = 0; c<maxInput/10; c++){
			threadSum += curValue + c;
		}
		
		sum += threadSum;
		pthread_exit(0);
}