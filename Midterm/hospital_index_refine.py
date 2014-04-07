import csv
    
refinefile = open(r'c:\users\nandu\phython\data1.csv', 'w')
refinefile.write('ID,Hospital_name,rate1,rate2,rate3,rate4,rate5,rate6\n')
with open(r'C:\Users\Nandu\Desktop\umkc\KDM\exam\Hospital_Outcome_Of_Care_Measures.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile)
    for row in spamreader:
        x = ''
        if row[0]=='Not Available':
            x += 'None,'
        else:
            x+=row[0]+',' 
        if row[10]=='Not Available':
            x += 'None,'
        else:
            x+=row[10]+','
        if row[16]=='Not Available':
            x += 'None,'
        else:
            x+=row[16]+','
        if row[22]=='Not Available':
            x += 'None,'
        else:
            x+=row[22]+','
        if row[28]=='Not Available':
            x += 'None,'
        else:
            x+=row[28]+','
        if row[34]=='Not Available':
            x += 'None,'
        else:
            x+=row[34]+','
        if row[40]=='Not Available':
            x += 'None\n'
        else:
            x+=row[40]+'\n'
        refinefile.write(x)
refinefile.close()