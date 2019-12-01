from stackapi import StackAPI
import sys
import csv

SITE = StackAPI('stackoverflow',key='o552c3nN4UUzGxUxsZAJiw((')
queryWords = " ".join(sys.argv[1:])
searchResults = SITE.fetch('search/advanced',title=queryWords,accepted=True)
_tag = "_".join(sys.argv[1:])

for item in searchResults['items']:
    row = []
    row.append(item['question_id'])
    row.append(_tag)
    row.append(item['link'])
    row.append(item['tags'])
    row.append(item['link']+'/'+str(item['accepted_answer_id'])+'#'+str(item['accepted_answer_id']))
    with open(_tag+'.csv', 'a+') as csvfile:
        csv.writer(csvfile).writerow(row)