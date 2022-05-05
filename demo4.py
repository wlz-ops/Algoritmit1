

def kapsakki(paino, arvo, kapasiteetti, n):

    if n==0 or kapasiteetti == 0:
        return 0
    
    
    if paino[n-1] <= kapasiteetti:
        s[n][kapasiteetti] = max(arvo[n-1] + kapsakki(paino, arvo, kapasiteetti-paino[n-1], n-1), kapsakki(paino, arvo, kapasiteetti, n-1))
        return s[n][kapasiteetti]
    elif paino[n-1] > kapasiteetti:
        s[n][kapasiteetti] = kapsakki(paino, arvo, kapasiteetti, n-1)
        return s[n][kapasiteetti]
        

arvo = [2, 3, 1, 4, 5 ]
paino = [1, 2, 3, 4, 5 ]
kapasiteetti = 7
n = len(arvo)
s = [[0 for i in range(kapasiteetti + 1)] for j in range(n+1)]

print("Tuotteiden arvot ovat: ", arvo,"€")
print("Tuotteiden painot ovat: ", paino, "kg")
print("Kapsäkin kapasiteetti on ",kapasiteetti,"kg.")
print ("Maksimi arvo ed. tuotteista, jotka mahtuvat kapsäkkiin on ",kapsakki(paino, arvo, kapasiteetti, n),"€")

arvo = [120, 33, 617, 24, 95 ]
paino = [71, 92, 53, 64, 95 ]
kapasiteetti = 170
n = len(arvo)
s = [[0 for i in range(kapasiteetti + 1)] for j in range(n+1)]

print("\nTuotteiden arvot ovat: ", arvo,"€")
print("Tuotteiden painot ovat: ", paino, "kg")
print("Kapsäkin kapasiteetti on ",kapasiteetti,"kg.")
print ("Maksimi arvo ed. tuotteista, jotka mahtuvat kapsäkkiin on ",kapsakki(paino, arvo, kapasiteetti, n),"€")
