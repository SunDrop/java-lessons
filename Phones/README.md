# Урок "ООП. Наследование."
Даны некоторые базовые модели классов телефонов.

* Написать класс наследник SamsungS4 с диагональю экрана 5 дюймов, поддержкой Wifi и методом отправки SMS, который будет дописывать к сообщению слово “Hello”.
* Модифицировать класс Phone так, чтобы он считал количество звонков и сообщений отдельно для каждого объекта и для всех объектов вместе.
* Написать код для связи телефонов между собой. У каждого телефона будет свой номер. При вызове call(number) телефон должен найти собеседника по номеру number из всех доступных в данный момент телефонов и вызвать его метод answer().

Результат:
```
name.sundrop.phones.Nokia3310 class is calling to 111-11-11
Занято! Вы звоните самому себе. Повторите попытку позднее, когда голоса в голове будут слышны четче.
name.sundrop.phones.Nokia3310 class is calling to 222-22-22
name.sundrop.phones.IPhone: 222-22-22 answer + красивая мелодия!
name.sundrop.phones.IPhone class is calling to 444-44-44
name.sundrop.phones.SamsungS4: 444-44-44 answer + защита головы от ветра!
name.sundrop.phones.IPhone5 class is calling to 111-11-11
name.sundrop.phones.Nokia3310: 111-11-11 answer!
name.sundrop.phones.SamsungS4 class is calling to 333-33-33
name.sundrop.phones.IPhone5: 333-33-33 answer + красивая мелодия!
name.sundrop.phones.IPhone5: 333-33-33 answer + красивая мелодия + видеоконференция!
name.sundrop.phones.SamsungS4 class is calling to 555-55-55
Указанный номер не существует!
----------------------------------
name.sundrop.phones.Nokia3310: 111-11-11, количество исходящих звонков: 2, количество входящих звонков: 1
name.sundrop.phones.IPhone: 222-22-22, количество исходящих звонков: 1, количество входящих звонков: 1
name.sundrop.phones.IPhone5: 333-33-33, количество исходящих звонков: 1, количество входящих звонков: 1
name.sundrop.phones.SamsungS4: 444-44-44, количество исходящих звонков: 2, количество входящих звонков: 1
name.sundrop.phones.SamsungS4: 777-77-77, количество исходящих звонков: 0, количество входящих звонков: 0
Всего исходящих звонков: 6
```
