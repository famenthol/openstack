#!/bin/bash
cp ./rsyncd.conf /etc/rsyncd.conf
systemctl restart rsyncd
chkconfig rsyncd on
systemctl restart memcached
chkconfig memcached on
