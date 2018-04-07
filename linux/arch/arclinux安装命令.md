&emsp;安装archlinuc之前的准备-按照wifki引导安装

### 1.U盘启动

- 使用GPT分区、UEFI启动模式写入U盘

- 使用软件rufu

> 使用dd模式安装引导后就没有出现media test failure,check cable问题

### 2.磁盘分区

&emsp;90G固态
/swap 		8G
/      		15G
/boot/efi	8G
/home		剩余

- 查看选择硬盘--留意硬盘的size区分
 lsblk

&emsp;使用分区工具进行分区
&emsp;进入指定硬盘进行分区操作[parted/fdisk](https://www.cnblogs.com/onlybobby/p/7018788.html)


  - 进入硬盘
 parted /dev/sdb

  - 制定硬盘格式为gpt   msdos
 (parted) mklabel gpt

  - 查看硬盘分区信息
 (parted) print

  - /swap分区
 (parted) mkpart primary linuxswap 1M 8G   

  - /boot/efi分区
 (parted) mkpart primary ext4 8G 16G

  - /根分区
  (parted) mkpart primary ext4 16G 36G

  - /home分区
  (parted) mkpart primary ext4 36G 100%

  - 退出
  q

### 创建文件系统--格式化硬盘

- 查看分区情况
  fdisk -l

- 格式化ext4 普通分区
  mkfs.ext4 /dev/xxx

- 格式化swap
  mkswap /dev/xxx
  swapon /dev/xxx   //激活swap

### 挂载分区
&emsp;swap分区不用挂载

- home分区  挂载在/mnt/home下
  mkdir /mnt/home
  mount /dev/xxx /mnt/home

- 根分区挂载在/mnt下
  mount /dev/xxx /mnt

- efi分区
  mkdir -p /mnt/boot/efi
  mount /dev/xx /mnt/boot/efi

### 编辑国内镜像nano
  /etc/pacman.d/mirrorlist
  Server = http://mirrors.aliyun.com/archlinux/$repo/os/$arch

### 安装基本的系统
  pacstrap /mnt base base-devel

### 配置系统生成fstab文件
  genfstab -U /mnt >> /mnt/etc/fstab
  配置完成检查文件是否正确 使用 cat /mnt/etc/fastab

### 切换当前根目录
  arch-chroot /mnt

### 设定时区
  ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
  //设置时间标准 为 UTC，并调整 时间漂移:
  hwclock --systohc --utc

### 设置本地化
  pacman -S vim  //试一下能不能安装
  nano /etc/locale.gen   //把注释清掉en_US.UTF-8 UTF-8、zh_CN.UTF-8 UTF-8

  //执行locale-gen以生成locale讯息
  locale-gen
  //将系统 locale 设置为en_US.UTF-8
  echo LANG=en_US.UTF-8 > /etc/locale.conf

### 设置主机名
  echo myhostname > /etc/hostname
  //添加到hosts文件
  /etc/hosts
  127.0.1.1	myhostname.localdomain	myhostname

### 创建一个初始 RAM disk
  mkinitcpio -p linux

### 设置root密码
  passwd

### 设置网络--无线

- 安装上网需要的包
  pacman -S dialog wpa_supplicant netctl wireless_tools

- 查看网卡名字
  ip link show

[问题解决:](https://wiki.archlinux.org/index.php/Netctl#Job_for_netctl.40wlan.28....29.service_failed)
  &emsp;ip link set xxx down
  &emsp;netctl start xxx-ssid

### 开机引导

```
//如果不行再加上
pacman -S grub
grub-install –recheck /dev/sda
```

- 安装uefi版
  pacman -S grub-efi-x86_64

- efi管理器
  pacman -S efibootmgr

- 安装进efi分区
  grub-install –efi-directory=/boot/efi –bootloader-id=grub

- 生成配置文件
  grub-mkconfig -o /boot/grub/grub.cfg

### 退出chroot模式,并卸分区
  umount 分区
  shutdown now 拔开U盘再开机
