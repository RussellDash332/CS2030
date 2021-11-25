Logger.<Integer>of(5)
Logger<String> hello = Logger.<String>of("Hello")
try { Logger.<Object>of(hello); }
catch (Exception e) { System.out.println(e); }
try { Logger.<Integer>of(null); }
catch (Exception e) { System.out.println(e); }
