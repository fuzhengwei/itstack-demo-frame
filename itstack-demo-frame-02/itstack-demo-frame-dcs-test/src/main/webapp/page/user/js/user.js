layui.use(['form', 'table'], function () {
    var $ = layui.jquery,
        form = layui.form,
        table = layui.table;

    /*    $.ajax({
            type: 'post',
            url: '/api/demo01/queryNodeList.do',
            async: false,
            success: function (res) {
                if (res.code === 0) {
                    $('#schedulerServer').empty();
                    $.each(res.data, function (index, item) {
                        $('#schedulerServer').append(new Option(item.name, item.id));// 下拉菜单里添加元素
                    });
                    layui.form.render("select");
                }
            }
        });*/

    // 监听搜索操作
    form.on('submit(data-search-btn)', function (data) {
        var index = layer.msg("查询中，请稍后...", {icon: 16, time: false, shade: 0});
        //执行搜索重载
        table.reload('userTable', {
            where: {
                 json: JSON.stringify(globalUtil.serializeObject(data.field))
            }
        }, 'data');
        layer.close(index);
        return false;
    });

    // 事件操作
    $(".data-add-btn").on("click", function () {
        var checkTable = table.checkStatus('currentTableId')
        if (null == checkTable) return;

        var data = checkTable.data[0];

        var instruct = {};
        instruct.ip = data.ip;
        instruct.schedulerServerId = data.schedulerServerId;
        instruct.beanName = data.beanName;
        instruct.methodName = data.methodName;
        instruct.cron = data.cron;
        instruct.status = 1;

        $.ajax({
            type: 'post',
            url: '/api/pushInstruct',
            data: {
                json: JSON.stringify(instruct)
            },
            success: function (res) {
                if (res.code === 0) {
                    layer.msg('');
                    table.reload('currentTableId');
                } else {
                    layer.msg('');
                }
            }
        });

    });

    // 监听删除操作
    $(".data-delete-btn").on("click", function () {
        var checkTable = table.checkStatus('currentTableId')
        if (null == checkTable) return;

        var data = checkTable.data[0];

        var instruct = {};
        instruct.ip = data.ip;
        instruct.schedulerServerId = data.schedulerServerId;
        instruct.beanName = data.beanName;
        instruct.methodName = data.methodName;
        instruct.cron = data.cron;
        instruct.status = 0;

        $.ajax({
            type: 'post',
            url: '/api/pushInstruct',
            data: {
                json: JSON.stringify(instruct)
            },
            success: function (res) {
                if (res.code == 0) {
                    layer.msg('关闭成功');
                    table.reload('currentTableId');
                } else {
                    layer.msg('关闭失败');
                }
            }
        });
    });

    //监听表格复选框选择
    table.on('checkbox(currentTableFilter)', function (obj) {
        console.log(obj)
    });

    table.on('tool(currentTableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        } else if (obj.event === 'delete') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    });

});

menu = {};

util = {
    statusInfo: function (d) {
        if (d.status === 0) return '<span style="color: #5FB878;font-weight: bolder;">在校</span>';
        if (d.status === 1) return '<span style="color: #b8000e;font-weight: bolder;">毕业</span>';
    },
    formatDate: function (d) {
        return layui.util.toDateString(d.entryTime, 'yyyy-MM-dd HH:mm:ss');
    }
};