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