//ohjelma, joka kääntää merkkijonon sanat päinvastaiseen järjestykseen
#include <iostream>


using namespace std;

string kaanna(string lause){
    int len = lause.length();
    int n=len-1;
    for(int i=0; i<(len/2); i++){ //for-lause joka kääntää kirjaimet ympäri merkki kerrallaan
        char temp = lause[i];
        lause[i] = lause[n];
        lause[n] = temp;
        n--;
    }    
    return lause;    
}

string kaannaLause(string lause) {
    string lause2 = lause + " ";
    string esual = "";
    string buffer = "";
    
    for(long unsigned int i=0; i < lause2.length();i++){
        if(lause2[i] != ' '){
            buffer += lause2[i];
        }
        else {
            esual += kaanna(buffer) + " ";
            buffer = "";
        }
    }
    
    return esual;
}

string poistaValit(string lause)
{
    bool valilyonti = false;
    int n = lause.length(), i = 0, j = -1;

    while (++j < n && lause[j] == ' ');

    while (j < n)
    {
        if (lause[j] != ' ')
        {
            if ((lause[j] == '.' || lause[j] == ',' ||
                 lause[j] == '?') && i - 1 >= 0 &&
                 lause[i - 1] == ' ')
                lause[i - 1] = lause[j++];
 
            else
                lause[i++] = lause[j++];
            valilyonti = false;
        }
        else if (lause[j++] == ' ')
        {
            if (!valilyonti)
            {
                lause[i++] = ' ';
                valilyonti = true;
            }
        }
    }
    if (i <= 1)
        lause.erase(lause.begin() + i, lause.end());
    else
        lause.erase(lause.begin() + i - 1, lause.end());
        
    return lause;
}

int main()
{
    string lause = "algoritmien opiskelu on kivaa";
    string lause2 = " testataan ylimaaraisten valilyontien  poistoa    .";
   
    cout<<"alkuperäinen:\n"<< lause<<endl;
    lause = kaanna(lause);
    //cout<<lause<<endl;
    lause = kaannaLause(lause);
    cout<<"Käännetty:\n"<< lause<<endl;
    
    cout<<"\nAlkuperäinen testilause ja sen alla käännetty: \n"<< lause2<<endl;
    lause2 = poistaValit(lause2);
    lause2 = kaanna(lause2);
    lause2 = kaannaLause(lause2);
    cout<<lause2<<endl;
    return 0;
}
