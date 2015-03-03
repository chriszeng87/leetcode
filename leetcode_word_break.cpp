#include <string>
#include <unordered_set>
#include <vector>
#include <iostream>

using namespace std;

bool wordBreak(string s,unordered_set<string> &dict){
        vector<bool> f(s.length()+1,false);
        f[0] = true;
        for(int i = 1; i < s.length()+1 ;i ++){
            for (int j = i-1; j >= 0; j--){
            	//如果s[0...j-1]可以拆成集合dict中的字符串的子集，而且s[j...i]属于集合dict，
                if(f[j] && (dict.find(s.substr(j,i-j))!=dict.end())){//注意substr的用法，substr(pos,len)
                    f[i] = true;
                    continue;
                }
            }
        }
        for (int i = 1; i < f.size(); i++) {
        	cout << "f[" << i << "] = " << f[i] << endl;
        }
        return f[f.size()-1];
}

int main () {
	string str = "programcreek";
	unordered_set<string> dict_test;
	dict_test.insert("programcree");
	dict_test.insert("program");
	dict_test.insert("creek");
	bool result = wordBreak(str, dict_test);
	if (result) {
		cout << "word Break succ" << endl;
	} else {
		cout << "word Break failed" << endl;
	}

	return 0;
}
