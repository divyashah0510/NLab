# Create a new simulation object
set ns [new Simulator]

# Open the trace file for output
set tracefile [open "tcp.tr" w]
$ns trace-all $tracefile

# Set up a topology with three nodes
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create a link between nodes 1 and 2 with a bandwidth of 10 Mbps and a delay of 20ms
set link12 [$ns duplex-link $n1 $n2 10Mb 20ms DropTail]

# Create a link between nodes 2 and 3 with a bandwidth of 5 Mbps and a delay of 50ms
set link23 [$ns duplex-link $n2 $n3 5Mb 50ms DropTail]

# Set up a TCP connection from node 1 to node 3
set tcp [new Agent/TCP]
$tcp set class_ 1
$tcp attach $link12
set sink [new Agent/TCPSink]
$ns attach-agent $n3 $sink
$ns connect $tcp $sink
$tcp set fid_ 1

# Set up a FTP application to send data from node 1 to node 3
set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ftp set type_ FTP
$ftp set packetSize_ 1000
$ftp set rate_ 500k

# Set up the simulation time and start the simulation
$ns at 0.0 "$ftp start"
$ns at 10.0 "$ftp stop"
$ns at 11.0 "finish"

proc finish {} {
    global ns tracefile
    $ns flush-trace
    close $tracefile
    exec nam tcp.nam &
    $ns halt
}

# Run the simulation
$ns run
