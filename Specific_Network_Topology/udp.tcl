# Create a new simulation object
set ns [new Simulator]

# Open the trace file for output
set tracefile [open "udp.tr" w]
$ns trace-all $tracefile

# Set up a topology with three nodes
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create a link between nodes 1 and 2 with a bandwidth of 10 Mbps and a delay of 20ms
set link12 [$ns duplex-link $n1 $n2 10Mb 20ms DropTail]

# Create a link between nodes 2 and 3 with a bandwidth of 5 Mbps and a delay of 50ms
set link23 [$ns duplex-link $n2 $n3 5Mb 50ms DropTail]

# Set up a UDP connection from node 1 to node 3
set udp [new Agent/UDP]
$udp set class_ 1
$udp attach $link12
set null [new Agent/Null]
$ns attach-agent $n3 $null
$ns connect $udp $null

# Set up a CBR traffic generator to send packets from node 1 to node 3
set cbr [new Application/Traffic/CBR]
$cbr attach-agent $udp
$cbr set packetSize_ 1000
$cbr set rate_ 500k

# Set up the simulation time and start the simulation
$ns at 0.0 "$cbr start"
$ns at 10.0 "$cbr stop"
$ns at 11.0 "finish"

proc finish {} {
    global ns tracefile
    $ns flush-trace
    close $tracefile
    exec nam udp.nam &
    $ns halt
}

# Run the simulation
$ns run
