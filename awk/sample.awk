#!/usr/bin/awk -f

BEGIN { print "start" }
/^#/ { print "match " $0 } # <pattern>マッチ時に行を出力
NR % 2 == 0 { print "even " $0 } # 偶数行を出力
            { print "any " $0 } # 無条件で出力
END   { print "end" }
