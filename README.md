
# Network Lab Assignments

The repository has all the nesscary Assignments of network lab.




## Roadmap
The repository helps you in various different types of:

- Networking commands
    - ping
    - ipconfig / ifconfig 
    - tracepath / tracert / traceroute 
    - nslookup
    - netstat
    - curl
    - mtr
    - whois
    - tcpdump
    - ss
    - dig
    - route
    - host
    - arp
    - hostname
- NS2 simulation (TCP & UDP)
- Socket programming using Java(For UDP & TCP)
- WireShark 
- Routing Implementation


## Installation

- For installing wireshark in Linux O.S you need to execute following command :

```bash
  sudo apt-get install wireshark
```
After doing so run the next command
```bash
  sudo wireshark
```
- For installing ns2 and nam we need to execute the following two commands which are as follows:
  - Install the required dependencies, such as Tcl, Tk, and Xgraph, by running the following command in the terminal:
    ```bash
      sudo apt-get install build-essential autoconf automake libxmu-dev
    ```
  - Extract the ns-allinone-xxx.tar.gz file to a desired location using the following command:
    ```bash
      tar zxvf ns-allinone-xxx.tar.gz
    ```
  - Go to the extracted ns-allinone-xxx directory using the following command:
    ```bash
      cd ns-allinone-xxx
    ```
  - Run the following commands to configure, compile, and install ns2:
    ```bash
      ./configure --with-tcl-ver=8.5 --with-tk-ver=8.5
    ```
    ```bash
      make
    ```
    ```bash
      sudo make install
    ```
  - Go to the ns-xxx/ns-2.xxx directory using the following command:
    ```bash
      cd ns-xxx/ns-2.xxx
    ```
  - Run the following command to make ns2:
    ```bash
      make
    ```
  - Go back to the ns-allinone-xxx directory using the following command:
    ```bash
      cd ../../
    ```
  - Run the following command to install nam:
    ```bash
      ./install
    ```
  - Test the installation by running a sample simulation using the following command:
    ```bash
      ns ns-2.xxx/examples/indep-utils/cmu-scen-gen/cmu-scen-gen.tcl
    ```
- For installing tcpdump you need to execute following command:
  
  ```bash
  sudo apt install tcpdump
  ```
## Feedback

If you have any feedback, please reach out to us at ds3636005@gmail.com

