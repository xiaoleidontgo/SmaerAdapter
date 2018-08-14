# SmartAdapter

## 如何使用？

       SmartAdapterBuilder smartAdapterBuilder = new SmartAdapterBuilder();
        SmartAdapter simpleAdapter =
                smartAdapterBuilder
                        .registerHeader(R.layout.item_header_1)
                        .registerHeader(R.layout.item_header_2)
                        .registerFooter(R.layout.item_footer_1)
                        .registerFooter(R.layout.item_footer_2)
                        .registerItem(TitleContent.class, new TitleProvider())
                        .registerItem(ImageContent.class, new ImageProvider())
                        .registerItem(TypeExample1.class, new TypeJudgment<TypeExample1>() {
                            @Override
                            public IProvider onJudge(TypeExample1 typeExample) {
                                if (typeExample.type.equals("1"))
                                    return new Type1Provider();
                                else if (typeExample.type.equals("2"))
                                    return new Type2Provider();
                                else
                                    return new Type3Provider();
                            }
                        })
                        .registerItem(TypeExample2.class, new TypeJudgment<TypeExample2>() {
                            @Override
                            public IProvider onJudge(TypeExample2 typeExample2) {
                                if (typeExample2.type.equals("1"))
                                    return new Type4Provider();
                                return new Type5Provider();
                            }
                        })
                        .bindData(itemData)
                        .create();
        recyclerView.setAdapter(simpleAdapter);
        
## 有何优势？
        
        在以前的项目当中，当一些复杂的页面需要多条目展示的时候，如何没有一个好的代码实现方式，往往会伴随着条目逻辑的分散。
    在以后想要添加条目或者更改条目逻辑的时候需要在大量的代码中定位那一条目类型。<br>
        SmartAdapter将每个不同的条目交给一个Provider类管理，统一。如何以后需要添加一个条目只需要调用：<br>
         `registerItem(XX.class, new XXProvider()) ` 或 `registerItem(XX.class, new TypeJudgment<XX>() `<br>
    修改不同条目的逻辑也只需找到Item对应的Provider即可。<br>
        SmartAdapter不仅实现了以Class对应Provider的形式，还实现Class内不同的Type形式对应Provider的形式，且相互可共存使用<br>
        
##三：效果图

       ![image](https://github.com/xiaoleidontgo/SmartAdapter/raw/master//app/src/main/res/mipmap-xxhdpi/screenshot1.png)
       
        

