import csv
    
refinefile = open(r'c:\users\nandu\phython\hosp_id.txt', 'w')

with open(r'C:\Users\Nandu\Desktop\umkc\KDM\exam\Hospital_Outcome_Of_Care_Measures.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile)
    for row in spamreader:
        x = row[0]+'\t'+row[1]+'\n'
       
        refinefile.write(x)
refinefile.close()

