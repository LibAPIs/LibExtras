# LibExtras

A small package of helper functions.

## Maven Dependency

Include the library in your project by adding the following dependency to your pom.xml

```
<dependency>
	<groupId>com.mclarkdev.tools</groupId>
	<artifactId>libextras</artifactId>
	<version>1.5.1</version>
</dependency>
```

## Example

### Checksums

Generate checksums of data.

```
// MD5 Checksum
String md5  = LibExtrasHashes.sumMD5("test");

// SHA-256 Checksum
String sha = LibExtrasHashes.sumSHA256("test");
```

### OS Utilities

Operating System specific utilities.

```
// Determine OS
boolean isMac = LibExtrasOS.isMacOS();
boolean isWin = LibExtrasOS.isWindows();

// Host Info
String hostName = LibExtrasOS.getHostname();
String homeDir = LibExtrasOS.userHome();

// PID Files
LibExtrasOS.writePIDFile(".", "app.pid");
```

### Streams

Work with small streams.

```
// Write a file
LibExtrasStreams.writeFile(new File("test"), "test".getBytes());

// Read a file
String in = LibExtrasStreams.readFile(new File("test"));
```

### Strings

Work with strings

```
// Pad a string with 0's. [0099]
String padded = LibExtrasStrings.leadingZeros(99, 4);

// Returns a given hex string to bytes. [test]
String asHex = LibExtrasStrings.hexToBytes("74657374");

// Validate IPv4 addresses
boolean isIP = LibExtrasStrings.isIPAddress("1.2.3.4");
```

# License

Open source & free for all. ❤
