import csv

def value(z):
    if z<5:
        return 1
    elif z<10:
        return 2
    elif z<15:
        return 3
    elif z<20:
        return 4
    else:
        return 5
        
refinefile = open(r'c:\users\nandu\phython\indx.json', 'w')
y={}
with open(r'c:\users\nandu\phython\data1.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile)
    for row in spamreader:
        
        x = 0
        count =0
        for i in range(1,7):
            if ((row[i] != 'None')&(row[i] != '')&(row[i] != None)) :
                x+= float(row[i])
                count += 1
        try:
            z=x/count
            y[row[0]]=value(z)
        except ZeroDivisionError:
            y[row[0]]='NotAvailable'
        
refinefile.write(str(y))
refinefile.close()

