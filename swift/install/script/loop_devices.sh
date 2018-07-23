#!/bin/bash
sudo mkdir /srv/
sudo truncate -s 1GB /dev/swift-sda
sudo truncate -s 1GB /dev/swift-sdb
sudo truncate -s 1GB /dev/swift-sdc
sudo mkfs.xfs /dev/swift-sda
sudo mkfs.xfs /dev/swift-sdb
sudo mkfs.xfs /dev/swift-sdc
echo "/dev/swift-sda /srv/node/sda xfs loop,noatime,nodiratime,nobarrier,logbufs=8 0 0" >> /etc/fstab
echo "/dev/swift-sdb /srv/node/sdb xfs loop,noatime,nodiratime,nobarrier,logbufs=8 0 0" >> /etc/fstab
echo "/dev/swift-sdc /srv/node/sdc xfs loop,noatime,nodiratime,nobarrier,logbufs=8 0 0" >> /etc/fstab
sudo mkdir -p /srv/node/sda
sudo mkdir -p /srv/node/sdb
duno mkdir -p /srv/node/sdc
sudo mount /srv/node/sda
sudo mount /srv/node/sdb
sudo mount /srv/node/sdc
