#include <stdio.h>

int string_to_integer(char* s) {
	if(s == NULL) {
		return -1;
	}
	int sign = 1;
	char* p = s;
	if (*p == '-') {
		sign = -1;
		p++;
	}else if (*p == '+') {
		p++;
	}
	int result = 0;
	while(*p != '\0') {
		int value = (*p - '0');
		result = result * 10 + value;
		p++; 
	}
	result = sign * result;
	return result;
}


int main() {
	char str[] = "-12345";
	int ret = string_to_integer(str);
	printf("result = %d\n",ret);
	return 0;
}
