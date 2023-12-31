-- 코드를 입력하세요
SELECT B.USER_ID, B.NICKNAME, A.SUM FROM USED_GOODS_USER AS B
INNER JOIN 
    (
    SELECT WRITER_ID, SUM(PRICE) AS SUM FROM USED_GOODS_BOARD
    WHERE STATUS LIKE 'DONE'
    GROUP BY WRITER_ID
    HAVING SUM >= 700000
    ) AS A
ON B.USER_ID = A.WRITER_ID
ORDER BY A.SUM ASC