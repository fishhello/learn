find_number = {"1": "yes", "2": "onh", "3": "five", "4": "did", "5": "ok"}
your_number = input("请输入你的幸运数字：")
if your_number in find_number:
    your_value = find_number[your_number]
    print(your_value)
else:
    print("木有")
