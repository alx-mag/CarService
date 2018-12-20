package com.company.carservice

return """SELECT * FROM ${table} 
WHERE DAYOFMONTH(${column}) = DAYOFMONTH(CURDATE()) 
AND MONTH(${column}) = MONTH(CURDATE())""".toString()