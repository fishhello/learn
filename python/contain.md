## 容器
>list,tuple,dist等都是容器，容器也可以嵌套容器

### 列表中存列表
```python
lists = []
rap = ["1", "2", "3"]
rock = ["4", "5", "6"]
djs = ["7", "8", "9"]
lists.append(rap)
lists.append(rock)
lists.append(djs)
print(lists)

[['1', '2', '3'], ['4', '5', '6'], ['7', '8', '9']]
```
```python
#如果往其中一个元素中添加值，结果也会显示在lists中
rap = lists[0]
rap.append("hello")
print(lists)

[['1', '2', '3', 'hello'], ['4', '5', '6'], ['7', '8', '9']]
```

### 元组中存列表/字典，列表中存元组/字典
```python
#列表中存储元组
location = []
la = (12.11, 34.444)
chicago = (223.1, 565.4)
location.append(la)
location.append(chicago)
print(location)

[(12.11, 34.444), (223.1, 565.4)]
```
```python
#元组中存储列表
rap = ["1", "2", "3"]
rock = ["4", "5", "6"]
somemusic = (rap,rock)
print(somemusic)

(['1', '2', '3'], ['4', '5', '6'])
```
```python
#列表/元组存储字典
fruits = {"apple":"red","banana":"yellow"}
my_list = [fruits]
print(my_list)
my_tuple = (fruits,)
print(my_tuple)

[{'apple': 'red', 'banana': 'yellow'}]
({'apple': 'red', 'banana': 'yellow'},)
```

### 列表，字典，元组都可以成为字典中的值
```python
mydict = {
    "location": (40.221,74.222),
    "celebs": ["allen", "jay", "bacon"],
    "facts": {"state":"ny","country":"usa"}
}
print(mydict)

{'location': (40.221, 74.222), 'celebs': ['allen', 'jay', 'bacon'], 'facts': {'state': 'ny', 'country': 'usa'}}
```