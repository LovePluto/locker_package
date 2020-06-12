Given locker有位置，when 存包，then 存包成功，得到票据。  
Given locker没有位置，when 存包，then 存包失败。  
Given 已经存包的locker，有票，when 取包，then 取包成功。  
Given 已经存包的locker，有票，when 取包，取包，then 第二次取包失败。  
Given 已经存包的locker，伪造票据，when 取包，then 取包失败。  