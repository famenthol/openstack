#!/usr/bin/python
import os
list1 = ["python-swift-2.13.1-1.el7.noarch.rpm"]
status = os.system("sh /opt/orca/swift/script/loop_devices.sh")
print status
def install_swift():
  print("start install swift")
  path = "/opt/orca/swift/"
  for rpm_name in list1:
    command = "rpm -ivh " + path + rpm_name
    status = os.system(command)
    if status == 0:
      print("status is 0")
    else:
      print("status is %s"%status)
def init_rsyncd():
  status = os.system("sh /opt/orca/swift/script/rsyncd.sh")
def init_swift():
  status = os.system("sh /opt/orca/swift/script/init_swift.sh")
install_swift()
init_rsyncd()
init_swift()
