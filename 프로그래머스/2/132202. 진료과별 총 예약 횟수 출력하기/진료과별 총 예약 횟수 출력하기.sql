SELECT MCDP_CD, COUNT(*) AS CNT
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 5
GROUP BY MCDP_CD
ORDER BY CNT, MCDP_CD