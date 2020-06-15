Given locker有位置，包，when 存包，then 存包成功，得到票据。  
Given locker没有位置，when 存包，then 存包失败。  
Given 已经存包的locker，有票，when 取包，then 取包成功。  
Given 已经存包的locker，有票，when 取包，取包，then 第二次取包失败。  
Given 已经存包的locker，伪造票据，when 取包，then 取包失败。  

## Primary Robot
Given 管理两个都有位置的locker的robot，包，when 存包，then 存入locker1,返回票。  
Given 管理两个locker的robot，第一个locker满，第二个locker有位置，包，when 存包，then 存入locker2,返回票。
Given 管理两个locker的robot，两个locker都满，包，when 存包，then 存入失败，提示柜子已满。
Given 管理两个locker的robot，票，when 取包，then 取包成功。  
Given 管理两个locker的robot，无效票，when 取包，then 取包失败，提示票据无效。  
