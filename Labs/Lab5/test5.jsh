Student natasha = new Student("Natasha");
natasha.put(new Module("CS2040").put(new Assessment("Lab1", "B")))
natasha.put(new Module("CS2030").put(new Assessment("PE", "A+")).put(new Assessment("Lab2", "C")))
Student tony = new Student("Tony");
tony.put(new Module("CS1231").put(new Assessment("Test", "A-")))
tony.put(new Module("CS2100").put(new Assessment("Test", "B")).put(new Assessment("Lab1", "F")))
Roster roster = new Roster("AY1920").put(natasha).put(tony)
roster
roster.get("Tony").get("CS1231").get("Test").getGrade()
roster.get("Natasha").get("CS2040").get("Lab1").getGrade()
roster.get("Tony").get("CS1231").get("Exam")
roster.get("Steve")
roster.getGrade("Tony","CS1231","Test")
roster.getGrade("Natasha","CS2040","Lab1")
roster.getGrade("Tony","CS1231","Exam");
roster.getGrade("Steve","CS1010","Lab1");
new Roster("AY1920") instanceof KeyableMap
new Roster("AY1920").put(new Student("Tony")) instanceof KeyableMap
/exit
