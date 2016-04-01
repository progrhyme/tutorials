#!/usr/bin/env perl
use strict;
use warnings;
use 5.008_001;

my @subjects = qw/localhost www.google.com consul.gdi-external.local no-such-host 192.168.0.1/;

for my $h (@subjects) {
    if (my $ipaddr_bin = gethostbyname($h)) {
        my @ipaddr_arr = unpack("C4",$ipaddr_bin);
        my $ipaddr_str = sprintf("%u.%u.%u.%u",@ipaddr_arr);
        print "$h - $ipaddr_str\n";
    } else {
        print "$h - not found\n";
    }
}
