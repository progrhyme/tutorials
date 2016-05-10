describe 'Foo' do
  before :context do
    p 'before context'
  end
  before do
    p 'before example'
  end

  it '1st case' do
    expect(true).to be true
  end

  it '2nd case' do
    expect(true).to be true
  end
end
