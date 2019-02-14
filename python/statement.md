## 语句

### if语句
```python
if xxx:
    执行xxx
else:
    执行xxx
```
```python
age = input("请输入您的年龄：")
int_age = int(age)
if(int_age < 21):
    print("litle young")
else:
    print("old!!")
```

### for
```python
for i in range(100):
    print("xxxx")
```

### try catch
>如果存在多个异常 catch需要使用(xx,xx)
```python
try:
    执行语句
catch 会发生的错误:
    执行语句
```
```python
try:
    print(1/0)
catch ZeroDivisionError:
    print("0 is error ")
```
