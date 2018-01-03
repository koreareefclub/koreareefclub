import os
import json
import sys
from urllib2 import urlopen
import time

path='C:\Users\Dawn\Documents'
file='0827-1127_Dockets.xml'

import xml.etree.ElementTree as ET
tree = ET.parse(file)
title=[]

for elem in tree.iter():
    print elem.text
    title.append(elem.text)
	
del title[0]

APIkey = 'PB36zotwgisM02kED1vWwvf7BklqCObDGVoyssVE'
APIUrl='https://api.data.gov/regulations/v3/'
api_url='{}docket.json?APIkey={}&docketId='.format(APIUrl, APIkey)

Max=15
try:
    for i in title:
        docketID=i
        url=api_url+i
        response = urlopen(url)

        #Max=raw_input("What is the max number of comments for each docket in this list?")

        input=raw_input("Would you like to create a new file with these docket IDs removed? (Y/N)")

        save_path='C:/test/'
        if not os.path.isdir(save_path):
                    os.makedirs(save_path)

        for key, value in response.items():
            if type(value) == int and value < Max:
                content={
                             'docketID':docketID,
                             'title': response['title'],
                             'numberOfComments': response['numberOfComments']        
                            }
                nullcontent={}
                output='\n'.join('{0}:{1}'.format(key, val) for key, val in sorted(content.items()))+'\n_____________________________________________________\n'
                nulloutput=''
                print "Processable docket's info:"+output
                if input=='Y':

                    name = 'docket_summary.txt'
                    nullname='removed_dockets.txt'
                    xmlname='new_docket_list.xml'
                    try:
                        print('Creating new text file')
                        completeName=os.path.join(save_path, name)
                        file=open(completeName, 'a')
                        #'a' creates the file if it does not exist but if it does exist it simply adds to it. 'w', on the other hand, deletes the existing one and creates a new one.
                        file.write(output)
                        print 'Creating a new XML file'
                        completexmlName=os.path.join(save_path, xmlname)
                        f=open(completexmlName, 'a') 
                        xmlcontent='<dkt>' +  str(docketID) + '</dkt> \n'
                        f.write(xmlcontent)
                        f.close
                        print ("A summary file has been created in location: "+save_path+xmlname)


                    except:
                        print('Error')

                elif input=='N': print "Opt not to create txt. file"
                else: print "Please enter either N/Y"





            elif key == u'numberOfComments' and type(value) == int and value >= Max:
                nullcontent={
                             'docketID':docketID,
                             'title': response['title'],
                             'numberOfComments': response['numberOfComments']        
                            }
                content={}
                nulloutput='\n'.join('{0}:{1}'.format(key, val) for key, val in sorted(nullcontent.items()))+'\n_____________________________________________________\n'
                output=''
                print "Unprocessable docket's info:"+nulloutput
                if input=='Y':

                    name = 'docket_summary.txt'
                    nullname='removed_dockets.txt'
                    xmlname='new_docket_list.xml'
                    try:
                        print('Creating new text file')

                        completenullName=os.path.join(save_path, nullname)
                        file=open(completenullName, 'a')
                        file.write(nulloutput) 
                        print nulloutput
                        print ("Your new DocketID List has been created in location: "+save_path+nullname)         
                    except:
                        print('Error')

                elif input=='N': print "Opt not to create txt. file"
                else: print "Please enter either N/Y"

        time.sleep(3)
        
except Exception, ex:
    print 'error:', ex
    print json.loads(urlopen(url)).get('errors')[0]