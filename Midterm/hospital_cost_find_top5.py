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
         
refinefile = open(r'c:\users\nandu\phython\final.json', 'w')
y={}
with open(r'c:\users\nandu\phython\data2.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile)
    for row in spamreader:
        x = row[0]
        if x not in y:
            y[x]={}
            if len(y[x])<6:
                y[x][row[1]]=row[2]
            else:
                if row[2] < max(y[x].values()):
                    z=max(y[x].values())
                    for i in y[x].keys():
                        if y[x][i]==z:
                            del y[x][i]
                            y[x][row[1]]=row[2]
        else:
            if len(y[x])<6:
                y[x][row[1]]=row[2]
            else:
                if row[2] < max(y[x].values()):
                    z=max(y[x].values())
                    for i in y[x].keys():
                        if y[x][i]==z:
                            del y[x][i]
                            y[x][row[1]]=row[2]
    
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