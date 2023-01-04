#! /usr/bin/gawk -f
BEGIN {
	FS=" "
	E404 = 0;
	E401 = 0;
	errorsPerIP[$1];
}

{ connection[$1] += 1 }


/ 404 /{
   E404++;
   errorsPerIP[$1]++;
}

/ 401 /{
   E401++;
   errorsPerIP[$1]++;
}



END {


	printf("Access Log Summary\n");
	printf("==================\n");
	printf("\n");
	printf("\n");
	printf("TOTAL NUMBER OF ENTRIES: " NR "\n");
	printf("%-50s %10s %10s", "Client", "Attempts", "Errors\n");
	printf("====================================================================================\n");



	for (origin in connection)
	{
	  printf("%-50s %10s %10s \n", origin,connection[origin],errorsPerIP[origin]);
	}


	printf("--------------------------------------------------------------------------\n");
	printf("\n");
	printf("\n");
	printf("Error Summary\n")
	printf("==========================================================================\n");
	printf("   401:   " E401 "\n");
	printf("   404:   " E404 "\n");
	printf("==========================================================================\n");
	for (origin in connection)
	{
		if(errorsPerIP[origin]>80){
		printf("***ALERT: " errorsPerIP[origin] " unauthorized attempts from " origin "\n");
		}
	}
	printf("===========================================================================\n");
}

