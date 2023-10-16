
# README: Device Network Communication System

## Overview
The given code aims to create a system that simulates the connectivity and communication between various devices in a network. The devices considered are Phones, Computers, and Routers. The primary functionality of this system is to determine if two devices can communicate with each other, given the connections they have.

**Note:** The connections between devices are unidirectional. This means if device A is connected to device B, device B might not necessarily be connected to device A.

## Classes

### 1. Device (Abstract Class)
The `Device` class is the parent class for all devices and provides the following:

- A unique `id` for identification.
- A `type` to denote the kind of device (e.g., COMPUTER, PHONE, ROUTER).
- A list of `connectedDevices` which maintains devices connected to the current device.
- Methods to manage connections and check communication capabilities.

#### Key Methods:
- `connect(Device d)`: Connects the current device to another device. Remember, the connection is unidirectional.
- `canCommunicateWith(Device device)`: Checks if the current device can communicate with the specified device using a depth-first search (DFS) mechanism.
- `dfsRecursively(Device current, Device wanted)`: A private recursive method that performs the DFS traversal to determine connectivity.

### 2. Computer
A child class of `Device` which represents a computer in the network.

### 3. Phone
A child class of `Device` which represents a phone in the network.

### 4. Router
A child class of `Device` which represents a router in the network.

### 5. Network (Main Class)
This class creates an instance of the network, connects devices, and tests their communication capabilities.

## Depth-First Search (DFS) Mechanism
To determine if two devices can communicate, the system uses the DFS algorithm. Starting from the source device, it traverses through each connected device until it finds the destination device or exhausts all possibilities.

During traversal:

1. The system marks the current device as visited.
2. If the current device is the wanted device, the method returns `true`.
3. If not, it recursively checks all unvisited devices connected to the current device.

## Expected Output of the Main Method

Given the unidirectional connections created in the `Network` class:

- Phone1 is connected to Phone2.
- Phone2 is connected to Computer1.
- Computer1 is connected to Router1.
- Router1 is connected to Computer2.

The expected output is:

```
PHONE (1) -> PHONE (2) -> COMPUTER (1) -> ROUTER (1) -> COMPUTER (2)
Phone1 -> Computer2: true
--------------------------

COMPUTER (2) 
Computer2 -> Phone1: false
--------------------------

PHONE (2) 
Phone2 -> Router2: false
```

## Conclusion
This system provides an elegant way of simulating device communications in a network with unidirectional connections. By extending the base `Device` class, it's also scalable to other device types in the future.
