Mazovia charset
===============
Java implementation of Mazovia encoding.
Mazovia encoding is used under MS-DOS to represent Polish texts. Basically it is code page 437 with some positions filled with Polish letters.

Usages:
======

# Get mazovia bytes from String:
=================

```
byte[] mazoviaBytes = "Gżegżółka".getBytes(Charset.forName("mazovia"));
```

# Create String from mazoviaBytes:

```
byte[] mazowiaBytes = new byte[]{(byte)143, (byte)134, (byte)149}; // Ą ą Ć
String str = new String(mazoviaBytes, Charset.forName("mazovia"));
```