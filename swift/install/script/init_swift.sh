#!/bin/bash
cp ./account-server.conf /etc/swift/account-server.conf
cp ./container-server.conf /etc/swift/container-server.conf
cp ./object-server.conf /etc/swift/object-server.conf
cp ./swift.conf /etc/swift/swift.conf
cp ./proxy-server.conf /etc/swift/proxy-server.conf
cd /etc/swift
swift-ring-builder account.builder create 18 3 1
swift-ring-builder container.builder create 18 3 1
swift-ring-builder object.builder create 18 3 1
swift-ring-builder account.builder add --region 1 --zone 1 127.0.0.1 --port 6202 --device sda --weight 100
swift-ring-builder container.builder add --region 1 --zone 1 127.0.0.1 --port 6201 --device sda --weight 100
swift-ring-builder object.builder add --region 1 --zone 1 127.0.0.1 --port 6200 --device sda --weight 100
swift-ring-builder account.builder add --region 1 --zone 1 127.0.0.1 --port 6202 --device sdb --weight 100
swift-ring-builder container.builder add --region 1 --zone 1 127.0.0.1 --port 6201 --device sdb --weight 100
swift-ring-builder object.builder add --region 1 --zone 1 127.0.0.1 --port 6200 --device sdb --weight 100
swfit-ring-builder account.builder add --region 1 --zone 1 127.0.0.1 --port 6202 --device sdc --weight 100
swift-ring-builder container.builder add --region 1 --zone 1 127.0.0.1 --port 6201 --device sdc --weight 100
swift-ring-builder object.builder add --region 1 --zone 1 127.0.0.1 --port 6200 --device sdc --wewight 100
swift-ring-builder account.builder rebalance
swift-ring-builder container.builder rebalance
swift-ring-builder object.builder rebalance
