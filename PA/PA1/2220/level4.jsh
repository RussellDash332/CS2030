Planner p = new Planner();
Task t = new Task(1,12,14,"lunch with boss")
p.add(t)
p
p = p.add(t)
p = p.add(new Task(3,16,18,"dinner with spouse"))
t = new Task(3,7,8,"fetch kids to school")
p = p.add(new RecurringTask(t,1,5))
p = p.add(new Task(3,14,15,"nap").cancel())
System.out.println(p.toString())