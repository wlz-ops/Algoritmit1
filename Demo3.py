from numpy import * 

class Lintu:
    def __init__(self, laji, indeksi):
        self.laji = laji
        self.indeksi = indeksi

kiuru=Lintu('kiuru ', -1) 
lokki=Lintu('lokki ', -1)
rastas=Lintu('rastas', -1)
sorsa=Lintu('sorsa ', -1)
varis=Lintu('varis ', -1)

pvJoukko = array ([kiuru, lokki, rastas, sorsa, varis])

print("Tilanne alussa, josta tulostus taulukon elementeille 0...n-1 alla, \ntaulukon indeksointi alkaa numerosta 0.\nKaikki solmut ovat itsenäisiä solmuja, joten kaikilla alussa i=-1.")

def tulosta(): #Funktio taulukon tulostamiseen
    q=0
    print ("_n|___str__|_i__|")   
    for obj in pvJoukko:
        print( q, obj.laji, obj.indeksi, sep =' | ' )
        q=q+1

tulosta()

def union(a, b):
    # Oletus: a ja b juurisolmuja
        print("ajetaan union (", pvJoukko[a].laji,",", pvJoukko[b].laji,")")
        k = pvJoukko[a].indeksi + pvJoukko[b].indeksi

        if pvJoukko[a].indeksi <=  pvJoukko[b].indeksi: 
            pvJoukko[a].indeksi = k
            pvJoukko[b].indeksi = a
        else:
            pvJoukko[b].indeksi = k
            pvJoukko[a].indeksi = b
    
print ("\nTulostetaan tilanne vaiheen 1 jälkeen, jossa")
union(0, 1)
tulosta()
print ("\nTulostetaan tilanne vaiheen 2 jälkeen, jossa")
union(2, 3)
tulosta() 

def find(x):
# Juurisolmun etsintä:
    j = x
    print("Tulostus tilanteesta sen jälkeen kun on etsitty ",pvJoukko[x].laji,"ja tiivistetty hakupolku.")
    while pvJoukko[j].indeksi >= 0 :
        j = pvJoukko[j].indeksi
# Hakupolun tiivistys:
    while pvJoukko[x].indeksi >= 0:
        k = x
        x = pvJoukko[x].indeksi
        pvJoukko[k].indeksi = j
    print("find-funktio palauttaa arvon", j)
    tulosta()
    return j
    

print ("\nTulostetaan tilanne vaiheen 3 jälkeen, jossa")    
union(2, 4)
tulosta()
print ("\nTulostetaan tilanne vaiheen 4 jälkeen, jossa")
union(0, 2)
tulosta()
print("\nAjetaan find-funktion.")
find(1)
