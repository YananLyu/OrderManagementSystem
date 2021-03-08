# SPU
INSERT INTO oms_test.pms_spu
    (id, create_time, create_user, platform_seller, product_link, product_name, update_time, update_user)
    VALUES
           (1, '2021-03-03 21:47:53', null, 'Amazon', 'https://www.amazon.com/gp/product/B0869L1326?ie=UTF8&psc=1&linkCode=sl1&tag=fatcoupon2021-20&linkId=b889811a9048614af88109ed8b8f1b2f&language=en_US&ref_=as_li_ss_tl', 'ASUS laptop', null, null);
INSERT INTO
    oms_test.pms_spu (id, create_time, create_user, platform_seller, product_link, product_name, update_time, update_user)
    VALUES (2, '2021-03-04 23:44:38', null, 'Costco', 'https://www.costco.com/xbox-series-s-with-additional-controller.product.100699182.html,', 'Xbox游戏手柄', null, null);
INSERT INTO oms_test.pms_spu
    (id, create_time, create_user, platform_seller, product_link, product_name, update_time, update_user)
VALUES
    (3, '2021-03-04 23:47:12', null, '三星官网', 'https://www.samsung.com/us/computing/buy/?CID=afl-ecomm-cjn-cha-092118-53026&cjevent=5d303c707c8411eb80c0016e0a1c0e11&utm_source=11557370&utm_medium=100334236&utm_campaign=0FOF63161473724829234&AID=11557370&PID=100334236&SID=0FOF63161473724829234', '三星笔记本', null, null);
INSERT INTO oms_test.pms_spu
    (id, create_time, create_user, platform_seller, product_link, product_name, update_time, update_user)
    VALUES (9, '2021-03-05 00:51:24', null, 'Dell官网', 'https://deals.dell.com/en-us/mpp/productdetail/7tog?AID=889052&cjevent=c955b4fa7d5e11eb83ec00340a1c0e14&cjdata=MXxOfDB8WXww&gacd=9614781-23761182-5750457-265988609-127889515&dgc=af&VEN1=12578053-889052-11000_1692869_0-PricePP%20LLC-https://deals.dell.com/en-us/mpp/productdetail/7tog&dclid=COTVm6uUmO8CFUeuAQodFAUMbw', 'DEll笔记本', null, null);



# Sku
INSERT INTO oms_test.pms_sku
    (id, commission_bonus, create_time, create_user, inventory_id, offer_note, offer_status, quantity, quantity_left, unit_price, update_time, update_user, spu_id)
    VALUES (1, 11.01, '2021-03-05 00:51:24', null, 1, '两种颜色都要。', 1, 12, 12, 538.99, null, null, 9);