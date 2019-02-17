## 循环
### for循环
> for [变量名] in [可迭代对象]
```python
name = "shafish"
for char in name:
    print(char)
```
```python
tv = ["error","ok","false","true"]
i = 0
for show in tv:
    new = tv[i]
    new = new.upper()
    tv[i] = new
    i += 1


print(tv)

['ERROR', 'OK', 'FALSE', 'TRUE']
```
```python
tv = ["error","ok","false","true"]
for i, show in enumerate(tv):
    new = tv[i]
    new = new.upper()
    tv[i] = new


print(tv)

同上
```

### range函数
>可以使用range创建一个整数序列，第一个参数：起始数字，第二个数字：结束数字

```python
for i in range(1, 9):
    print(i)

1....9
```

### while循环
> while true:执行代码

```python
x = 10
while x > 0:
    print('{}'.format(x))
    x -= 1
print("新年好！！")

10 9 .... 2 1 新年快乐
```

### break
> 终止循坏

```python
for i in range(1, 6):
    print(i)
    if i == 2:
        break
```

### continue
> 跳过本次循坏

xxxx

### 嵌套循坏
> for循坏里存在for循坏

xxxxu8

