-- 코드를 입력하세요
SELECT DISTINCT A.CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
INNER JOIN CAR_RENTAL_COMPANY_CAR AS B 
ON A.CAR_ID = B.CAR_ID
WHERE MONTH(A.START_DATE) = 10 AND B.CAR_TYPE = '세단'
ORDER BY CAR_ID DESC