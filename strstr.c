#include <stdio.h>
char *strstr(const char *s1,const char *s2)
{
    int n;
    if(*s2)
    {
        while(*s1)
        {
            for(n=0;*(s1+n)==*(s2+n);n++)
            {
                if(*(s2+n+1) == '\0')
                    return (char*)s1;
            }
            s1++;
        }
        return NULL;
    }
    else
        return (char*)s1;
}

int main() {
	char *str1 = "GoldenGlobalView";
	char *str2 = "lob";
	char *p;
	p = strstr(str1, str2);
	if(p)
		printf("%s\n", p);
	else 
		printf("NotFound!\n");

	return 0;
}
