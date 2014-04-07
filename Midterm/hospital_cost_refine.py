import csv
    
refinefile = open(r'c:\users\nandu\phython\data2.csv', 'w')
with open(r'C:\Users\Nandu\Desktop\umkc\KDM\exam\Inpatient_Prospective_Payment_System__IPPS__Provider_Summary_for_the_Top_100_Diagnosis-Related_Groups__DRG_.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile)
    for row in spamreader:
        x = row[0]+','+row[1]+','+row[10]+'\n'
        refinefile.write(x)
refinefile.close()

