Task t = new Task(1,12,14,"lunch with boss")
new RecurringTask(t, 7, 4)
RecurringTask rt = new RecurringTask(t, 7, 4)
t.cancel() // this is cancelling t, not rt!
rt // rt is not affected by cancelling t!
rt.cancel()
rt.cancel().cancel()
rt.cancel().edit()
rt.edit(11, 13)
rt.edit(11, 13).cancel()