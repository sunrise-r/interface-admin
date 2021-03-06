# Документация по Interface Administrator (Iad)

**Iad** - это инструмент, который позволяет быстро создавать таблицы и формы на основе мета описаний в формате JSON.

Для работы с этим замечательным инструментом, вам нужно знать Java (backend разработка библиотеки разрабатывается в отдельном репозитории), JSON и Angular7 (TypeScript).

## Что вы можете сделать, используя Iad?

Во-первых, это, конечно же, списки данных и CRUD операции. В списках поддерживается описание набора кнопок, специфичного для конкретного списка/таблицы.

Во-вторых, формы. Поддерживается возможность создания сложных вложенных форм с настройкой вложенности.

В-третьих, отображение view отдельной сущности.

Описание мета информации построено на основе понятий &quot;представление&quot; (presentation) и &quot;проекция&quot; (projection).

## Философия

Философия состоит в том, что каждый документ имеет некое представление. Это представление может проецироваться в разных проекциях. Например: допустим, есть документ, который называется &quot;User&quot; (пользователь). Эти пользователи могут быть в представлении таблицы для выполнения CRUD операций с полным списком данных, но также у нас может возникнуть необходимость отображать этих пользователей в формах в LookupInput (ввод данных путём выбора из списка или таблицы). Также, эти данные могут быть использованы вообще в других вариантах: это могут быть таблицы,  списке данных, укороченные списки, списки с разным набором кнопок (Actions). Это справедливо и для форм - один и тот же набор данных может быть представлен в разных формах.

Представление - это структура, формирующая текущее визуальное представление сущностей. Представление может содержать список проекций, описывающих списки элементов (ListProjection), список проекций для описания форм создания/редактирования элементов (FormProjection) и список проекций, описывающих отображение отдельной сущности (DataProjection)

## Наследование

Как проекции форм, так и проекции списков могут наследоваться друг от друга. Наследование подразумевает объединение некоторых полей проекций с родительской проекцией. Остальные поля дочерней проекции не наследуются и должны вводиться индивидуально для каждой проекции.

- ListProjection:
  - infoUrl (адрес для запроса данных),
  - columns (колонки)
  - actions (списки кнопок)
  - defaultSortOrder (порядок сортировки для таблицы/списка)
  - defaultSortField (поле сортировки для таблицы/списка)

- FormProjection:
  - fields (поля проекций форм)

- DataProjection:
  - наследование не реализовано.

## Из чего состоят представления и проекции?

1. **Представления**

    Для того чтобы создать представление (presentation) необходимо создать файл вида {CamelCaseName}Presentation.json и ввести его поля. Поля, отмеченные \*, являются обязательными для заполнения:

    - **label** : Название представления. Может быть использован, например, для заголовков страниц. На данный момент не используется frontend частью библиотеки.
    - **code** : Код представления, который используется в качестве parentCode проекций этого представления и позволяет однозначно связать проекции и представление.
    - **parentCode** Код родительской записи. Для всех представлений в этом поле указывается корень проекта. Эта информация будет использована при итоговом построении дерева интерфейсов.

1. **Проекции списка (ListProjection)**

    Для того чтобы создать проекцию списка необходимо создать файл вида {CamelCaseName}ListProjection.json и ввести его поля. Поля, отмеченные \*, являются обязательными для заполнения:

    | **Поле** | **Тип** | **Описание** | **Комментарий** |
    | --- | --- | --- | --- |
    | **label\*** | String | Название проекции. Например, разделенный точками путь к строке перевода |   |
    | **code\*** | String | Код проекции в формате {CamelCaseName}ListProjection |   |
    | **parentCode\*** | String | Код родительской записи. Эта информация будет использована при итоговом построении дерева интерфейсов. |   |
    | description | String | Описание проекции. Для чего предназначена, зачем создана |   |
    | displayType | String | Тип проекции. В зависимости от типа проекции, она может быть отрисована разными способами(например список или таблица) | На момент написания документации никак не используется на frontend, отсутствует в DTO |
    | searchUrl | String | Путь до ресурса |   |
    | infoUrl | String | Url для получения подробной информации для конкретной записи.К нему в конце всегда добавляется id выбранной в талице/списке записи |   |
    | order | Integer | Порядок для сортировки проекций |   |
    | extends | ParentReference | Возможность указать проекцию и представление для наследования текущей проекции | Ниже, в этой документации описана структура ParentReference |
    | defaultSortOrder | String | Порядок сортировки по умолчанию для таблицы/списка |   |
    | defaultSortField | String | Поле для сортировки по умолчанию для таблицы/списка |   |
    | settingsGroupName | String | Название группы пользовательских настроек. В эти настройки могут быть сохранены данные о сортировке, порядке вывода столбцов, их видимости и тд |   |
    | resourceSearchUrl | String | Адрес для запроса данных в elastic | DEPRECATED |
    | actions | List\&lt;Action\&gt; | Доступные для представления действия (используются как кнопки связанного с таблицей тулбара) | Ниже, в этой документации описана структура Action |
    | fields | List\&lt;ListField\&gt; | Описание полей проекции | Ниже, в этой документации описана структура ListField |
    | filters | List\&lt;ProjectionFilter\&gt; | Список фильтров, по умолчанию применяемых к выводу записей этой проекции | Ниже, в этой документации описана структура ProjectionFilter |
    | loadActualInfo | Boolean | Загружать ли информацию из infoUrl при клике на запись в таблице |   |
    | properties | HashMap\&lt;String, Object\&gt; | карта свойств текущей проекции со строковыми ключами. |   |

    1. Рассмотрим отдельно специальные типы полей проекции

        **Action:**

        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | label | String | Название действия. Например, разделенный точками путь к строке перевода |   |
        | **code\*** | String | Код действия |   |
        | displayType | String | Способ отображения Действия. Например: кнопка, ссылка |   |
        | group | String | Группа действий. может быть использована для группировки |   |
        | style | String | Стиль визуального элемента |   |
        | toggle | boolean | Флаг, может ли быть кнопка Включена/выключена кликом мышки |   |

        **ListField:**
        
        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | **label\*** | String | Название столбца. Например, разделенный точками путь к строке перевода |   |
        | **code\*** | String | Код столбца для получения данных списка/таблицы |   |
        | formatter | String | Формат отображения поля в компоненте |   |
        | displayFormat | String | Компонент отображения данных |   |
        | sorting | boolean | Доступна сортировка или нет |   |
        | searching | boolean | Доступен ли поиск по полю |   |
        | translationCode | String | Код перевода |   |
        | style | boolean | Поле используется для задания стиля колонки, который будет применен на фронтенде |   |
        | position | String | Определяет позицию колонки в таблице |   |
        | properties | HashMap\&lt;String, Object\&gt; | карта свойств текущего поля со строковыми ключами. |   |

        **ParentReference**
        
        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | presentationCode | String | Код представления |   |
        | projectionCode | String | Код проекции |   |
        
        **ProjectionFilter**
        
        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | field | String | Название фильтра |   |
        | values | List\&lt;String\&gt; | Значения фильтров |   |
        | operator | String | Оператор для значений фильтра |   |

1. **Проекции формы (FormProjection)**

    Для того чтобы создать проекцию списка необходимо создать файл вида {CamelCaseName}FormProjection.json и ввести его поля. Поля, отмеченные \*, являются обязательными для заполнения:
    
    | **Поле** | **Тип** | **Описание** | **Комментарий** |
    | --- | --- | --- | --- |
    | label | String | Название проекции. Например, разделенный точками путь к строке перевода | На момент написания документации никак не используется на frontend, отсутствует в DTO |
    | **title\*** | String | Название проекции. Например, разделенный точками путь к строке перевода |   |
    | **code\*** | String | Код проекции в формате {CamelCaseName}FormProjection |   |
    | **parentCode\*** | String | Код родительской записи. Эта информация будет использована при итоговом построении дерева интерфейсов. |   |
    | description | String | Описание проекции. Для чего предназначена, зачем создана |   |
    | displayType | String | Тип проекции. В зависимости от типа проекции, она может быть отрисована разными способами | На момент написания документации никак не используется на frontend, отсутствует в DTO |
    | extends | ParentReference | Возможность указать проекцию и представление для наследования текущей проекции | Выше, в этой документации описана структура ParentReference |
    | fields | List\&lt;FormField\&gt; | Список полей формы | Ниже, в этой документации описана структура FormField |
    | className | String | Название класса в JAVA для обработки формы. Может быть использовано для корректного определения сущности, которая создаётся при помощи формы |   |
    | actionUrl | String | URL, на который будет отправлена форма. Может быть в виде шаблона underscore ||
    | formType | String | Тип формы для возможности фильтрации на frontend ||
    | properties | HashMap\&lt;String, Object\&gt; | карта свойств текущей проекции со строковыми ключами. |   |

    1. Рассмотрим отдельно специальные типы полей проекции

        **FormField**
        
        Описание инпутов формы. Исторически так сложилось, что Frontend принимает поля формы под другими названиями. Для того, чтобы сопоставить поля, вводимые в JSON и поля, принимаемые на стороне frontend, название поля, ожидаемое Frontend будет указано в отдельном столбце ( **Поле на Frontend** ). Само сопоставление полей на стороне frontend происходит в файле /iad-interface-admin/form/src/lib/projection-form/public-services/iad-projection-form.service.ts
        
        | **Поле** | **Поле на Frontend** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- | --- |
        | label | - | String | Название поля. | На момент написания документации поле не используется |
        | code | - | String | Код поля | На момент написания документации поле не используется |
        | formatter | - | String | Компонент отображения данных. не используется | На момент написания документации поле не используется |
        | displayFormat | - | String | Формат отображения поля в компоненте. не используется | На момент написания документации поле не используется |
        | datasourcePath | datasourcePath или dataSourcePath | String | Источник данных для поля. Используется для заполнения поля данными при отрисовке компонента. Бывает так что название поля в компоненте не совпадают по названию с источником данных. Это поле используется, чтобы решить эту проблему. Если оно указано, то движок на фронтенде должен попытаться получить данные по указанному пути. |   |
        | defaultValue |   | String | Значение поля по умолчанию. |   |
        | fieldType | type | String | Тип поля, например, string; Это поле используется вместо formatter | Ниже, в этой документации описаны типы полей, доступные &quot;Из коробки&quot; |
        | fieldName | name | String | Код поля. Подставляется в name инпута |   |
        | fieldLabel | label | String | Название поля, отображается в label инпута |   |
        | required | - | boolean | Флаг &quot;обязателен&quot; | Не используется, в пользу validationTypes |
        | fieldLength |   | String | Длина поля при ручном вводе. Вводится в кавычках. | Не используется, в пользу validationTypes |
        | fieldInputType | fieldInputType | String | Тип инпута на форме. Используется в контексте DISABLED, READONLY и тд. | Изначально предполагалось использование по типу displayFormat |
        | column | column | Integer | Номер колонки для отображения поля. Позволяет форматировать форму так, чтобы инпуты располагались в колонках |   |
        | hidden | - | boolean | Флаг &quot;Скрыто&quot; | Поле предполагалось на случай, если оно должно быть скрытое, но fieldType его вполне заменяет,Deprecated |
        | valueField | valueField | String | Поле, необходимое для Инпутов типа Lookup (Entity и List). Указывает на поле из sourceListProjectio, которое должно быть подставлено в форму | Во фронтендной версии библиотеки отсутствуют Lookup поля. Их реализация остаётся на усмотрение разработчика |
        | lookupViewProjectionCode | lookupViewProjectionCode | String | Поле, необходимое для инпутов типа Lookup (Entity и List). Указывает на код проекции списка для отображения уже выбранных в Lookup записей | Во фронтендной версии библиотеки отсутствуют Lookup поля. Их реализация остаётся на усмотрение разработчика |
        | lookupSourceProjectionCode | lookupSourceProjectionCode | String | Поле, необходимое для инпутов типа Lookup (Entity и List). Указывает на код проекции списка для отображения списка записей для выбора в Lookup | Во фронтендной версии библиотеки отсутствуют Lookup поля. Их реализация остаётся на усмотрение разработчика |
        | referenceProjectionCode | referenceProjectionCode | String | Поле, необходимое для инпутов типа Reference (ссылочных инпутов). Указывает на код проекции формы для запроса вложенной формы |   |
        | presentationCode | presentationCode | String | Поле, необходимое для инпутов типа Lookup (Entity и List) и Reference (ссылочных инпутов). Указывает на код представления для получения проекций, указанных в полях lookupViewProjectionCode, lookupSourceProjectionCode, referenceProjectionCode |   |
        | inputMask | inputMask | String | Маска ввода для полей, поддерживающих ручной ввод. | В случае установки значения этого поля, будет применён компонент PrimeNG Mask [https://www.primefaces.org/primeng-7.1.3/#/inputmask](https://www.primefaces.org/primeng-7.1.3/#/inputmask) |
        | validationTypes | validationTypes | ValidationDto | Правила фронтендной валидации для поля. | Ниже, в этой документации есть описание доступных правил валидации ValidationDto |
        | translate | translate | boolean | Флаг, указывающий на необходимость перевода fieldLabel на стороне фронтенда |   |
        | visible | - | boolean | Поле предполагалось на случай, если оно должно быть скрытое или видимое, но fieldType его вполне заменяет, Deprecated |   |
        | properties | properties | HashMap\&lt;String, Object\&gt; | карта свойств поля со строковыми ключами. | Ниже, в этой документации есть описание того, как эта структура применяется для настройки некоторых типов полей ввода |
        
        **ValidationDto**
        
        Правила валидации ручного ввода значения поля
        
        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | max | String | Максимальное значение для числового поля |   |
        | min | String | Минимальное значение для числового поля |   |
        | maxLength | String | Максимальная длина |   |
        | minLength | String | Минимальная длина |   |
        | mask | String |   | Не используется |
        | email | boolean | Флаг, устанавливающий, является ли данное поле emmail |   |
        | required | boolean | Флаг, устанавливающий, является ли данное поле обязательным |   |

1. **Проекции превью данных (DataProjection)**

    Проекции превью данных предназначены для показа read-only информации о конкретной записи.
    
    Для проекта &quot;Партнёр&quot; было определено, что DataProjection необходимо создавать относящимися не к обычному Presentation, а к DataPresentation.
    
    Для того чтобы создать проекцию превью данных необходимо создать файл вида {CamelCaseName}DataProjection.json и ввести его поля. Поля, отмеченные \*, являются обязательными для заполнения:
    
    | **Поле** | **Тип** | **Описание** | **Комментарий** |
    | --- | --- | --- | --- |
    | **label\*** | String | Название проекции. Например, разделенный точками путь к строке перевода |   |
    | **code\*** | String | Код проекции в формате {CamelCaseName}DataProjection |   |
    | **parentCode\*** | String | Код родительской записи. Эта информация будет использована при итоговом построении дерева интерфейсов. |   |
    | description | String | Описание проекции. Для чего предназначена, зачем создана |   |
    | displayType | String | Тип проекции. В зависимости от типа проекции, она может быть отрисована разными способами | На момент написания документации никак не используется на frontend, отсутствует в DTO |
    | extends | ParentReference | Возможность указать проекцию и представление для наследования текущей проекции | Выше, в этой документации описана структура ParentReference |
    | fields | List\&lt;DataField\&gt; | Список полей превью |   |
    | documentPhoto | String | Путь, разделённый точками до поля во входящих данных для превью, содержащего путь для загрузки изображения превью. Например, &quot;documentIndex.photo&quot;, если входящие данные имеют в структуре:{  &quot;documentIndex&quot;: {    &quot;photo&quot;: &quot;path/to/photo.png&quot;  }} | Для проекта &quot;Партнёр&quot; документация доступна в Wiki |
    | properties | HashMap\&lt;String, Object\&gt; | карта свойств текущей проекции со строковыми ключами. |   |

    1. Рассмотрим отдельно специальные типы полей проекции

        **DataField**
        
        | **Поле** | **Тип** | **Описание** | **Комментарий** |
        | --- | --- | --- | --- |
        | **label** | String | Название поля. |   |
        | **code** | String | Код поля |   |
        | formatter | String | Компонент отображения данных. |   |
        | displayFormat | String | Формат отображения поля в компоненте. |   |
        | datasourcePath | String | Источник данных для поля. Используется для заполнения поля данными при отрисовке компонента. Бывает так что название поля в компоненте не совпадают по названию с источником данных. Это поле используется, чтобы решить эту проблему. Если оно указано, то движок на фронтенде должен попытаться получить данные по указанному пути. |   |
        | defaultValue | String | Значение поля по умолчанию. |   |
        | properties | HashMap\&lt;String, Object\&gt; | карта свойств поля со строковыми ключами. |   |

## Комментарии в JSON

В проекции описание можно создавать не только в поле description. Часто используется способ комментирования через JSON поле &quot;\_\_comment&quot;, этот параметр игнорируется парсером и не участвует в построении дерева представлений.

## Скрипт для проверки JSON

При создании дерева представлений и проекций, все собранные JSON файлы загружаются в память сервера, таким образом доступ к этим данным производится максимально быстро.

Это, однако, порождает проблему сломанного JSON. Если файлы JSON были созданы вручную, то высока вероятность ошибки ввода. Легко можно забыть двойные кавычки или поставить лишнюю запятую даже при использовании продвинутых средств разработки. Для исключения ситуаций, когда один плохой JSON рушит всю структуру, перед отправкой на сборку проекта можно запустить простой JS скрипт

```ecmascript 6
    const readdir = require("recursive-readdir");
    
    const path = require("path");
    
    const fs = require("fs");
    
    readdir(path.join(__dirname, "../../../../main/resources/iad/user")).then(
    
        function(files) {
    
            let hasError = false;
    
            const count = files.length;
    
            files.forEach((f, i) => {
    
                fs.readFile(f, "utf-8", (err, data) => {
    
                    if (err) {
    
                        hasError = true;
    
                        console.error(`Cannot read file ${f}!`, err);
    
                    }
    
                    try {
    
                        JSON.parse(data);
    
                        if (i === count - 1 && hasError === false) {
    
                            console.info(`Cheers! Everithing is ok in your JSONs!`);
    
                        }
    
                    } catch (error) {
    
                        hasError = true;
    
                        console.error(`${f} is not correct JSON file!`, error);
    
                    }
    
                })
    
            })
    
        },
    
        function(error) {
    
            console.error('incorrect path', error);
    
        }
    
    );
```


## Типы полей форм, доступные из коробки:

Формы в IAD имеют предустановленный набор типов полей ввода. Тип поля ввода указывается в FormField в свойстве fieldType. Ввод регистронезависимый. Поля, отмеченные символом &quot;**(\*)**&quot;, имеют дополнительные настройки через properties, которые описаны в таблице ниже.

| **Тип поля ввода (fieldType)** | **Соответствующая модель**** на frontend **|** Соответствующий компонент ****на frontend** | **Описание** |
| --- | --- | --- | --- |
| BigDecimal, Integer **(\*)** | NumberInput | IadFormNumberComponent | \&lt;input type=&quot;number&quot; /\&gt;. Эти два типа поля ссылаются на один и тот же компонент |
| Boolean | BooleanInput | IadFormCheckboxComponent | \&lt;input type=&quot;checkbox&quot; /\&gt;. |
| MultiSelect **(\*)** | DropdownMultiInputModel | IadFormDropdownComponent | PrimeNG компонент MultiSelect [https://www.primefaces.org/primeng-7.1.3/#/multiselect](https://www.primefaces.org/primeng-7.1.3/#/multiselect) |
| Dropdown **(\*)** | DropdownInputModel | IadFormDropdownComponent | PrimeNG компонент Dropdown [https://www.primefaces.org/primeng-7.1.3/#/dropdown](https://www.primefaces.org/primeng-7.1.3/#/dropdown) |
| Rich | RichEditorInput | IadFormRichEditorComponent | PrimeNG компонент Editor [https://www.primefaces.org/primeng-7.1.3/#/editor](https://www.primefaces.org/primeng-7.1.3/#/editor) |
| ZonedDateTime **(\*)** | DateInput | IadFormDateComponent | PrimeNG компонент Calendar[https://www.primefaces.org/primeng-7.1.3/#/calendar](https://www.primefaces.org/primeng-7.1.3/#/calendar) |
| Chips | ChipsInputModel | IadFormChipsComponent | PrimeNG компонент Chips[https://www.primefaces.org/primeng-7.1.3/#/chips](https://www.primefaces.org/primeng-7.1.3/#/chips) |
| String | TextInput | IadFormInputComponent | \&lt;input type=&quot;text&quot; /\&gt; или, если указано свойство InputMask, то PrineNG компонент Mask[https://www.primefaces.org/primeng-7.1.3/#/inputmask](https://www.primefaces.org/primeng-7.1.3/#/inputmask) |
| StringTranslated | TextInputTranslated | IadFormTranslateInputComponent | \&lt;input type=&quot;text&quot; readonly=&quot;true&quot; /\&gt;, значение будет автоматически переведено библиотекой ngx-translate ([https://github.com/ngx-translate/core](https://github.com/ngx-translate/core)) |
| Hidden | HiddenInput | IadFormInputComponent | \&lt;input type=&quot;hidden&quot; /\&gt;. |
| File | FileInput | IadFormFileComponent | \&lt;input type=&quot;file&quot; /\&gt;. Этот компонент не осуществляет саму загрузку файлов. Только формирует input. Загрузка файлов остаётся на усмотрение разработчиков, т.к. она может быть реализована по-разному в зависимости от требований проекта |
| SplittedDateTime **(\*)** | DateTimeInput | IadFormDateTimeComponent | PrimeNG компонент Calendar[https://www.primefaces.org/primeng-7.1.3/#/calendar](https://www.primefaces.org/primeng-7.1.3/#/calendar) |
| Text | TextareaInput | IadFormTextareaComponent | \&lt;textarea\&gt;\&lt;/textarea\&gt; |
| password | TextInput | IadFormInputComponent | \&lt;input type=&quot;password&quot; /\&gt;. |
| AutoComplete **(\*)** | AutoCompleteInput | IadFormAutoCompleteInputComponent | PrimeNG компонент Autocomplete[https://www.primefaces.org/primeng-7.1.3/#/autocomplete](https://www.primefaces.org/primeng-7.1.3/#/autocomplete) |
| ProjectionReference**(\*)** | FormInputGroup | IadFormGroupComponent | Ссылка на другую проекцию формы  в любом указанном представлении. Обычно используется специальное представление для набора форм, на которые может ссылаться форма ввода. Компонент формирует вложенную форму с полями, которые frontend загружает по указанным представлению и проекции. Поля вложенной форма могут быть отправлены как вложенная структура данных или в одном уровне с основной формой. |

Properties любой сущности могут быть использованы по своему усмотрению и обработаны извне библиотеки IAD при загрузке представлений и проекций. Но некоторые Properties, в частности, используются для тонкой настройки полей форм, описанных выше.

| **Поле** | **Property** | **Тип** | **Описание** |
| --- | --- | --- | --- |
| AutoComplete | valuesUrl | String | URL для получения подгружаемых значений autocomplete |
| forceSelection | boolean (false) | Флаг, сообщающий компоненту, что значение можно вводить только из подгружаемых данных |
| ZonedDateTime, SplittedDateTime | dataType | String (&#39;date&#39;|&#39;string&#39;) | Тип данных - date или string |
| dateFormat | String (dd.mm.yyyy) | Формат даты |
| Dropdown, MultiSelect | valuesUrl | String | URL для получения подгружаемых значений dropdown |
| labelField | String (&#39;label&#39;) | Поле из подгружаемых данных для показа пользователю |
| valueField | String (&#39;value&#39;) | Поле из подгружаемых данных для отправки на backend |
| multiple | boolean (&#39;false&#39;) | Флаг для активации множественного выбора в select |
| showHeader | boolean (&#39;true&#39;) | Флаг для активации строки поиска по значениям multiselect. Работает только при установке multiple: true |
| maxSelectedLabels | Number (3) | Ограничение на число одновременно выбираемых опций multiselect. Работает только при установке multiple: true |
| translatePrefix | String | Префикс, используемый для перевода значений dropdown |
| showClear | boolean (false) | Флаг для активации кнопки очистки поля. Работает только для multiple: false |
| Integer, BigDecimal | step | Number (1) | Шаг изменения числа в input типа number |
| ProjectionReference | flattenData | boolean (false) | Флаг, устанавливающий для ссылочного поля настройку, что загруженные поля будут отправлены на backend в виде вложенной структуры (false), Либо на одном уровне с полями ссылающейся формы. (true) |
| flattenFields | boolean (false) | Флаг, устанавливающий для ссылочного поля настройку, что загруженные поля будут показаны в форме в виде вложенной группы (false), Либо на одном уровне с полями ссылающейся формы. (true) |
| plainReference | boolean (false) | Флаг, устанавливающий flattenData и  flattenFields в true. Рекомендуется не использовать его, а пользоваться flattenData и  flattenFields |
| collapsed | boolean (true) | Флаг, устанавливающий в случае flattenFields: false настройку, что вложенная группа должна быть свёрнута (true) или развёрнута (false) при начальном отображении формы |

Продолжение документации касается Frontend части библиотеки AID и описано в рамках IAD-frontend