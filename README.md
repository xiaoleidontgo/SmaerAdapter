# SmartAdapter
一个Android下Recyclerview的适配器库，方便Recyclerview的多条目构建，简易，高效的维护多条目

1,如何使用？

        List<Object> itemData = new ArrayList<>();

        TitleContent titleContent = new TitleContent();
        titleContent.title = "行走的每一天";
        titleContent.Content = "行走在世界，奔走在你的心里";
        titleContent.dateLine = "2017-08-18";

        ImageContent imageContent = new ImageContent();
        imageContent.imgUrl = "http://baidu.com/helloworld";
        imageContent.uploadUser = "蚂蚁的一天";
        imageContent.uplodTime = "2017-08-19";

        TypeExample1 typeExample11 = new TypeExample1();
        typeExample11.type = "1";
        typeExample11.content = "TypeExample1-> Type=1";

        TypeExample1 typeExample12 = new TypeExample1();
        typeExample12.type = "2";
        typeExample12.content = "TypeExample1-> Type=2";

        TypeExample1 typeExample13 = new TypeExample1();
        typeExample13.type = "3";
        typeExample13.content = "TypeExample1-> Type=3";

        TypeExample2 typeExample21 = new TypeExample2();
        typeExample21.type = "1";
        typeExample21.content = "TypeExample2-> Type=1";

        TypeExample2 typeExample22 = new TypeExample2();
        typeExample22.type = "2";
        typeExample22.content = "TypeExample2-> Type=2";

        itemData.add(titleContent);
        itemData.add(imageContent);
        itemData.add(typeExample11);
        itemData.add(typeExample12);
        itemData.add(typeExample13);

        itemData.add(typeExample21);
        itemData.add(typeExample22);

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(simpleAdapter);
